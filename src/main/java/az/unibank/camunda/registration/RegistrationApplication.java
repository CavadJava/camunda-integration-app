package az.unibank.camunda.registration;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class RegistrationApplication {

    private final RuntimeService runtimeService;

    public RegistrationApplication(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public static void main(String... args) {
        SpringApplication.run(RegistrationApplication.class, args);
    }

    @EventListener
    private void processPostDeploy(PostDeployEvent event) {
        runtimeService.startProcessInstanceByKey("registration-form");
    }

}