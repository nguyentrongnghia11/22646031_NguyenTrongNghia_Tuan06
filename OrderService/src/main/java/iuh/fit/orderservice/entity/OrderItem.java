package iuh.fit.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private Order order;

    @Column(name = "food_id", nullable = false)
    private Long foodId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    /**
     * Tính toán tổng giá cho item này
     */
    public BigDecimal getTotalItemPrice() {
        if (unitPrice != null && quantity != null) {
            return unitPrice.multiply(new BigDecimal(quantity));
        }
        return BigDecimal.ZERO;
    }
}
