package cn.emam.unifyexception.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * people实体类
 * @author LiQiuShui
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Setter
@Getter
@ToString
@Entity
public class People implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "名字不能为空")
    private String name;

    @NotNull(message = "分数不能为空")
    private Double score;

    private String address;

    @Min(value = 18, message = "年龄必须大18岁")
    private Integer age;
}
