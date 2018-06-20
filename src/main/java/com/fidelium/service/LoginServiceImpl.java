package com.fidelium.service;

import com.fidelium.dao.UserMapper;
import com.fidelium.domain.User;
import com.fidelium.otp.GoogleOtp;
import com.fidelium.util.DateTimeUtil;
import com.fidelium.util.FileUtil;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-10-24.
 */
@Service
public class LoginServiceImpl implements LoginService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final Map<String, Boolean> excludes = new HashMap<>();

    private String limitSize;

    protected static final String LABEL = "FIDELIUM";

    @Autowired
    private UserMapper userMapper;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public int userCheck(User user){
        return userMapper.userCheck(user);
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException{
        User user = userMapper.getUser(id);
        logger.info(user.toString());
        user.setAuthorities(getAuthorities(id));
        logger.info("user.getAuthorities() : {}", user.getAuthorities());
        for(GrantedAuthority grantedAuthority : user.getAuthorities()){
            logger.info("grantedAuthority.getAuthority() : {}", grantedAuthority.getAuthority());
        }
        return user;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities(String id){
        Collection<GrantedAuthority> authorities = userMapper.readAuthority(id);
        return authorities;
    }

    @Override
    public User readUser(String id){
        User user = userMapper.readUser(id);
        user.setAuthorities(userMapper.readAuthority(id));
        return user;
    }

    @Override
    @Transactional
    public int createUser(User user){

        String oriPassword = user.getPassword();
        String encodedPassword = new BCryptPasswordEncoder().encode(oriPassword);
        user.setOriPassword(oriPassword);
        user.setPassword(encodedPassword);

        String encodedOtp = GoogleOtp.otpIdCreate();
        String qrUrl = GoogleOtp.getQRBarcodeURL(LABEL, user.getId().split("@")[0], user.getId().split("@")[1], encodedOtp);
        user.setOtpQrKey(encodedOtp);
        user.setOtpQrUrl(qrUrl);

        userMapper.createUser(user);
        userMapper.createAuthority(user);
        return 1;
    }

    @Override
    @Transactional
    public int updateUser(User user){
        if(user.getFiles() != null && user.getFiles().length > 0){
            user = this.fileUpload(user);
        }
        return userMapper.updateUser(user);
    }

    @Override
    @Transactional
    public int userPassUpdate(User user){
        String oriPassword = user.getPassword();
        String encodedPassword = new BCryptPasswordEncoder().encode(oriPassword);
        user.setOriPassword(oriPassword);
        user.setPassword(encodedPassword);
        return userMapper.userPassUpdate(user);
    }

    @Override
    @Transactional
    public void deleteUser(String id){
        userMapper.deleteUser(id);
        userMapper.deleteAuthority(id);
    }

    @Override
    public int realDeleteUser(String id){
        return userMapper.realDeleteUser(id);
    }

    @Override
    public PasswordEncoder passwordEncoder(){
        return this.passwordEncoder;
    }

    public User fileUpload(User user){
        try {
            MultipartFile multipart = user.getFiles()[0];
            String fileName = multipart.getOriginalFilename();
            long size = multipart.getSize();
            String ext = FileUtil.getExtension(fileName, size, excludes, limitSize);
            String baseDir = getTodayWithDirName();
            String destDir = FileUtil.makeDirectory("/imgFile", baseDir);
            // 파일 이름 변경
            String destFilename = FileUtil.getUuid(ext);
            String filePath = FilenameUtils.separatorsToUnix(baseDir + File.separator + destFilename);
            String absoluteFilePath = destDir + File.separator + destFilename;
            File file = new File(absoluteFilePath);
            multipart.transferTo(file);
            user.setFilePath(absoluteFilePath);
            user.setFileName(destFilename);
            user.setOriginFileName(fileName);
            user.setWebFilePath(filePath);
            if(file.isFile()){
                logger.info("{}", "파일등록성공");
            }else{
                logger.info("{}", "파일등록성공");
            }
            logger.info("{}", user.toString());
        }catch (Exception e){
            logger.info("{}", e.getMessage());
        }
        return user;
    }

    private String getTodayWithDirName() {
        return DateTimeUtil.getDateToString(null, DateTimeUtil.DIRECTORY_DATE_FORMAT2);
    }


}
