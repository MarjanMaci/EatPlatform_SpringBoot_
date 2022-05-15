package com.example.kasnisi.service.impl;

import com.example.kasnisi.model.CartItem;
import com.example.kasnisi.model.Employees;
import com.example.kasnisi.model.Orders;
import com.example.kasnisi.model.User;
import com.example.kasnisi.model.exceptions.ShoppingCartNotFoundException;
import com.example.kasnisi.repository.EmployeesRepository;
import com.example.kasnisi.repository.OrderRepository;
import com.example.kasnisi.service.OrderService;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final EmployeesRepository employeesRepository;

    public OrderServiceImpl(OrderRepository orderRepository, EmployeesRepository employeesRepository) {
        this.orderRepository = orderRepository;
        this.employeesRepository = employeesRepository;
    }

    @Override
    public Orders makeAnOrder(Date dateOfOrder, String discountCode, Long orderTotal, List<CartItem> items, User user) {
        Integer smallest = 99999;
        List<Employees> allEmployees = employeesRepository.findAll();
        Employees employeeToDeliver = null;
        for(Employees e : allEmployees){
            if(e.getOrdersList().size()<smallest){
                smallest=e.getOrdersList().size();
                employeeToDeliver=e;
            }
        }
        Orders newOrder = orderRepository.save(new Orders(new Date(), discountCode, orderTotal, items, user,employeeToDeliver));
        return newOrder;
    }

    @Override
    public List<Orders> listAllOrders(User user) {
        return orderRepository.getAllByClientThatOrdered(user);
    }

    @Override
    public List<Orders> allOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void changeStatus(Long id) {
        Orders o = orderRepository.findById(id).orElseThrow(()-> new ShoppingCartNotFoundException(id));
        o.setDelivered(true);
        orderRepository.save(o);
    }
}
