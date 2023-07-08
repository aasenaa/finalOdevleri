package com.senaaladag.finalOdevi;
import java.io.Serializable;
import com.senaaladag.data.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


//lombok
@Data
@NoArgsConstructor

//Entity
@Entity
@Table(name = "jquery")
public class JqueryEntity extends BaseEntity implements Serializable{
    //serileştirme
    public static final long serialVersionUID = 1L;

    @Column(name = "email")
    private String email;

    @Column(name = "password", columnDefinition = "varchar(255) default 'Hm123456@'")
    private String passwd;
    @Column(name = "text")
    private String firstName;
}