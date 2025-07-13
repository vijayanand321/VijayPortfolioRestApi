package com.vijay.portfolio.service.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Service;

import com.vijay.portfolio.model.FooterProperties;
import com.vijay.portfolio.service.FooterService;

@Service
public class FooterServiceImpl implements FooterService {

    private final FooterProperties footerProperties;
    private final ConfigurableEnvironment environment;

    public FooterServiceImpl(FooterProperties footerProperties, ConfigurableEnvironment environment) {
        this.footerProperties = footerProperties;
        this.environment = environment;
    }

    @Override
    public FooterProperties getFooter() {
        return footerProperties;
    }

    @Override
    public void updateFooter(FooterProperties newProps) {
        Map<String, Object> updates = new HashMap<>();

        if (newProps.getAddress() != null) {
            if (newProps.getAddress().getLine1() != null)
                updates.put("footer.address.line1", newProps.getAddress().getLine1());
            if (newProps.getAddress().getLine2() != null)
                updates.put("footer.address.line2", newProps.getAddress().getLine2());
            if (newProps.getAddress().getLine3() != null)
                updates.put("footer.address.line3", newProps.getAddress().getLine3());
            if (newProps.getAddress().getPincode() != null)
                updates.put("footer.address.pincode", newProps.getAddress().getPincode());
        }

        if (newProps.getPhone() != null)
            updates.put("footer.phone", newProps.getPhone());

        if (newProps.getEmail() != null)
            updates.put("footer.email", newProps.getEmail());

        if (newProps.getFacebook() != null)
            updates.put("footer.facebook", newProps.getFacebook());

        if (newProps.getLinkedin() != null)
            updates.put("footer.linkedin", newProps.getLinkedin());

        if (newProps.getInstagram() != null)
            updates.put("footer.instagram", newProps.getInstagram());

        if (newProps.getGithub() != null)
            updates.put("footer.github", newProps.getGithub());

        if (newProps.getAbout() != null)
            updates.put("footer.about", newProps.getAbout());

        environment.getPropertySources().addFirst(new MapPropertySource("dynamicFooter", updates));
    }
}


