package com.project.practice.workshop12.numbergenerator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import com.project.practice.workshop12.numbergenerator.Model.GenerateImage;

import java.util.logging.Level;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class numberController {

    private Logger logger = Logger.getLogger(numberController.class.getName());
    
    @GetMapping
    public String showForm() {
        return "numberForm";
    }

    @GetMapping(value="/number")
    public String generateRandomNumbers(@RequestParam String number, Model model) {

        List<Integer> numberToGenerate = new ArrayList<>(); 
        int n;
        try {
            n = Integer.parseInt(number);
        } catch (Exception e) {
            String errorMessage = "Error. Please input a valid number.";
            model.addAttribute("errorMessage", errorMessage);
            return "error";
        }
        
        if (n < 1 || n > 30) {
            String errorMessage = "Error. Please input a number between 1 and 30.";
            model.addAttribute("errorMessage", errorMessage);
            return "error";
        }

        Random rand = new Random();
        for (int i = 0; i < n; i++){
            int randomNumber = rand.nextInt(30) + 1;
            if (numberToGenerate.contains(randomNumber)){
                i-= 1;
            } else {
                numberToGenerate.add(randomNumber);
                logger.log(Level.INFO, "number added > " + randomNumber);
            }
        }

        List<GenerateImage> imageList = new ArrayList<>();

        for (int numberImage : numberToGenerate){
            String imageUrl = "images/number" + numberImage + ".jpg";
            GenerateImage num = new GenerateImage(numberImage,imageUrl); 
            imageList.add(num);
        }

        logger.log(Level.INFO,"List of numbers > " + numberToGenerate);
        model.addAttribute("numToGenerate", (String) number);
        model.addAttribute("imageList", imageList);

        return "generateNumbers";
    }
    
    
}
