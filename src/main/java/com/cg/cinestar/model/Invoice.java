package com.cg.cinestar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoices")
@Accessors(chain = true)
public class Invoice extends BaseEntity{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

//    @OneToMany(mappedBy = "invoice")
//    private Set<Ticket> tickets;


//    @OneToMany(mappedBy = "invoice")
//    private Set<OrderItemFood> OrderItemFoodList;


    @Column(name = "grand_total")
    private BigDecimal grandTotal;

}
