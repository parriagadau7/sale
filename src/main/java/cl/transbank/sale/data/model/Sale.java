package cl.transbank.sale.data.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Long id;
    private double total;
    @CreationTimestamp
    private LocalDateTime created;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany( mappedBy = "sale", cascade = CascadeType.ALL)
    private Set<Product> products;
}
