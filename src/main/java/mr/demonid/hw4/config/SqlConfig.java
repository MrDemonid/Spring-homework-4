package mr.demonid.hw4.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Конфигуратор для чтения sql-запросов из application.yml
 * Поскольку мы явно задали в каком пакете искать
 * файлы-конфигураторы (@ConfigurationPropertiesScan("...")), то
 * можно обойтись без аннотации @Configuration или @Component,
 * теперь Spring сам найдёт наш класс и добавит в контейнер.
 */
@Data
@ConfigurationProperties(prefix = "command.sql")
public class SqlConfig {
    String insert;
    String getUser;
    String getAllUser;
    String deleteUser;
    String updateUser;
}
