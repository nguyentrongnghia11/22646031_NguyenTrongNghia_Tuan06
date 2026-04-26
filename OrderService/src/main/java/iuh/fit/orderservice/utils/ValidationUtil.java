package iuh.fit.orderservice.utils;

import iuh.fit.orderservice.exception.InvalidOrderException;

public class ValidationUtil {

    public static void validateUserId(Long userId) {
        if (userId == null || userId <= 0) {
            throw new InvalidOrderException("Invalid user id");
        }
    }

    public static void validateFoodId(Long foodId) {
        if (foodId == null || foodId <= 0) {
            throw new InvalidOrderException("Invalid food id");
        }
    }

    public static void validateQuantity(Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new InvalidOrderException("Invalid quantity. Quantity must be greater than 0");
        }
    }
}
