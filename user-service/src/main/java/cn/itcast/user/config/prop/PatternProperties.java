package cn.itcast.user.config.prop;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "pattern")
@Data
public class PatternProperties {
    private String dateformat;
    private String common;
}
