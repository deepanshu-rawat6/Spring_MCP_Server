package org.sehn.spring_mcp;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoService {

    private static final Logger logger = LoggerFactory.getLogger(InfoService.class);

    private List<Info> information = new ArrayList<>();

    @Tool(name = "dr_get_information", description = "Get a list of information about Deepanshu Rawat")
    public List<Info> getInformation() {
        return information;
    }

    @Tool(name = "dr_get_info", description = "Get a specific information about Deepanshu Rawat")
    public Info getInfo(String title) {
        return information.stream().filter(info -> info.title().equals(title)).findFirst().orElse(null);
    }

    @PostConstruct
    public void init() {
        information.addAll(List.of(
                new Info("Portfolio", "https://bento.me/deepanshu-rawat6"),
                new Info("GitHub", "https://github.com/deepanshu-rawat6"),
                new Info("LinkedIn", "https://www.linkedin.com/in/deepanshu-rawat6/"),
                new Info("Twitter", "https://twitter.com/deepanshuurawat")
        ));


    }
}
