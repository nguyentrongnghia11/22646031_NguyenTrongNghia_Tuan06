package iuh.fit.orderservice.dto;

import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderCreateRequest {
    private Long userId;
    private String description;  // Mô tả sản phẩm/đơn hàng
    private List<OrderItemRequest> items;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class OrderItemRequest {
        private Long foodId;
        private Integer quantity;
        private BigDecimal price;
    }
}
