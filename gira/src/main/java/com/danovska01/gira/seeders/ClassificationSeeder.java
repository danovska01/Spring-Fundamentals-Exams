package com.danovska01.gira.seeders;

import com.danovska01.gira.models.ClassificaionName;
import com.danovska01.gira.models.Classification;

import com.danovska01.gira.repositories.ClassificationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class ClassificationSeeder implements CommandLineRunner {

    private final ClassificationRepository classificationRepository;

    @Autowired
    public ClassificationSeeder(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.classificationRepository.count() == 0) {

            List<Classification> classifications = Arrays.stream(ClassificaionName.values())
                    .map(name -> {
                        Classification classification = new Classification();
                        classification.setClassificationName(name);
                        return classification;
                    })
                    .collect(Collectors.toList());

            this.classificationRepository.saveAll(classifications);
            // n + 1 queries problem
        }

    }
}
