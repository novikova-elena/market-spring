package ru.novikova.market.core.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import ru.novikova.market.api.dtos.OrderDto;
import ru.novikova.market.core.entities.Order;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderConverter {
    private final OrderItemConverter orderItemConverter;

    public OrderDto entityToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setAddress(order.getAddress());
        orderDto.setPhone(order.getPhone());
        orderDto.setTotalPrice(order.getTotalPrice());
        orderDto.setUsername(order.getUsername());
        orderDto.setItems(order.getItems().stream().map(orderItemConverter::entityToDto).collect(Collectors.toList()));
        return orderDto;
    }
}
