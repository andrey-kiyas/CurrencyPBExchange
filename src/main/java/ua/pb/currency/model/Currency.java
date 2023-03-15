package ua.pb.currency.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CURRENCY")
@Data
public class Currency {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "OPERATION")
    private String currOper;

    @Column(name = "CCY")
    private String currCcy;

    @Column(name = "SUMM")
    private int currSumm;

    @Column(name = "EKV")
    private int currSummEkv;

}
