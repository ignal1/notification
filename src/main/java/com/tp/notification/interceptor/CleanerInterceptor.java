package com.tp.notification.interceptor;

import com.tp.notification.Settings;
import com.tp.notification.service.FileService;
import org.apache.commons.io.FileUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CleanerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        String tmpDirName = FileService.getTemporaryDirName().get();
        Path path = Paths.get(Settings.LOCATION + "/common/" + tmpDirName);

        if (Files.exists(path)) {
            FileUtils.deleteDirectory(path.toFile());
        }
    }
}
