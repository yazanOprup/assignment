package com.progresssoft.progresssoftassignment.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fx_deals")
@Getter
@Setter
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealId;

    @Column(name = "deal_unique_id", unique = true, nullable = false)
    @NotBlank(message = "Deal Unique ID is required")
    private String dealUniqueId;

    @Column(name = "from_currency_iso", nullable = false)
    @NotBlank(message = "From Currency ISO Code is required")
    private String fromCurrencyISO;

    @Column(name = "to_currency_iso", nullable = false)
    @NotBlank(message = "To Currency ISO Code is required")
    private String toCurrencyISO;

    
    @Column(name = "deal_timestamp", nullable = false)
    @NotBlank(message = "Deal Timestamp is required")
    private String dealTimestamp;

    @Column(name = "deal_amount", nullable = false)
    @NotNull(message = "Deal Amount is required")
    @Positive(message = "Deal Amount must be positive")
    private Double dealAmount;


    public Deal(Long dealId, String dealUniqueId, String fromCurrencyISO, String toCurrencyISO, String dealTimestamp, Double dealAmount) {
        this.dealId = dealId;
        this.dealUniqueId = dealUniqueId;
        this.fromCurrencyISO = fromCurrencyISO;
        this.toCurrencyISO = toCurrencyISO;
        this.dealTimestamp = dealTimestamp;
        this.dealAmount = dealAmount;
    }


}

