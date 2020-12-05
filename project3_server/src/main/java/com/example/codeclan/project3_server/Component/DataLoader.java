package com.example.codeclan.project3_server.Component;

import com.example.codeclan.project3_server.Models.Card;
import com.example.codeclan.project3_server.Models.Customer;
import com.example.codeclan.project3_server.Models.Order;
import com.example.codeclan.project3_server.Models.Trainer;
import com.example.codeclan.project3_server.Repository.CardRepository;
import com.example.codeclan.project3_server.Repository.CustomerRepository;
import com.example.codeclan.project3_server.Repository.OrderRepository;
import com.example.codeclan.project3_server.Repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    OrderRepository orderRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){

        Trainer jordans = new Trainer("https://static.highsnobiety.com/thumbor/6vgipAH4vfoc0_avcLXtiwgFOTs=/1600x1067/static.highsnobiety.com/wp-content/uploads/2020/03/03111612/nike-air-jordan-3-unc-release-date-price-02.jpg",
                "Jordan Mecurial", "Jordans", 4.1, 20, 40.67);

        jordans.getColours().add("red");
        jordans.getColours().add("green");


        Trainer nike = new Trainer("https://image.shutterstock.com/image-photo/chisinau-moldova-february-7-2017-260nw-622954634.jpg",
                "Nike ShutterShock", "Nike", 3.9, 10, 32);

        nike.getColours().add("blue");
        nike.getColours().add("white");


        List<Trainer> trainers = new ArrayList<>();
        trainers.add(nike);
        trainers.add(jordans);

       trainerRepository.save(nike);
       trainerRepository.save(jordans);

        Customer cyril = new Customer("Cyril Ishabiyi", "cyril@outlook.com", "comeUp", "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/111554483/original/83d513acbc4b3716c9a474086bb633a5de3c2d74/create-social-media-avatars-in-minimalist-style.jpg");

        customerRepository.save(cyril);


        cyril.addToCart(jordans);

        Order newOrder = cyril.buy();
        orderRepository.save(newOrder);
//        cyril.addOrder(newOrder);






        Trainer adidas = new Trainer("https://m.media-amazon.com/images/I/313Jdc5K3zL.jpg", "adiddda", "Adidas",
                3.5, 5, 26);

        adidas.getColours().add("green");
        adidas.getColours().add("blue");
        trainerRepository.save(adidas);
        trainerRepository.save(adidas);

        cyril.addToCart(adidas);
        cyril.addToCart(nike);
        Order thirdOrder = cyril.buy();
        orderRepository.save(thirdOrder);



        Card hsbcCard = new Card("Visa", "4678845", "07/22", 129, cyril);
        cardRepository.save(hsbcCard);
        cyril.getCards().add(hsbcCard);
        customerRepository.save(cyril);


        Customer craig = new Customer("Craig Alexander", "craig@outlook.com", "come",
                "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/111554483/original/83d513acbc4b3716c9a474086bb633a5de3c2d74/create-social-media-avatars-in-minimalist-style.jpg");

        customerRepository.save(craig);

        Card metroCard = new Card("Metro", "475634767", "09/22", 129, craig);
        cardRepository.save(metroCard);
        craig.addCard(metroCard);


        craig.addToCart(adidas);
        Order craigOrder = craig.buy();
        orderRepository.save(craigOrder);
        customerRepository.save(craig);





        Customer cam = new Customer("Campbell Murray", "campbell@outlook.com", "Up",
                "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/111554483/original/83d513acbc4b3716c9a474086bb633a5de3c2d74/create-social-media-avatars-in-minimalist-style.jpg");
        customerRepository.save(cam);

        Card payPal = new Card("PayPal", "45876567", "09/26", 567, cam);
        cardRepository.save(payPal);
        cam.addCard(payPal);

        cam.addToCart(jordans);
        Order camOrder = cam.buy();
        orderRepository.save(camOrder);
        customerRepository.save(cam);

//        cam.addToCart(nike);











    }
}