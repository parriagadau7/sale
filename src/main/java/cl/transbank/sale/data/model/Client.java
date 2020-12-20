package cl.transbank.sale.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Setter
@Getter
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private String phone;

    @OneToOne(mappedBy = "client")
    private Sale sale;
}
