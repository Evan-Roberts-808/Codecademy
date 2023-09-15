package com.codecademy.boots.controllers;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.codecademy.boots.repositories.BootRepository;
import com.codecademy.boots.entities.Boot;
import com.codecademy.boots.enums.BootType;
import com.codecademy.boots.exceptions.QueryNotSupportedException;
import com.codecademy.boots.exceptions.NotImplementedException;

@RestController
@RequestMapping("/api/v1/boots")
public class BootController {
    private final BootRepository bootRepository;
    public BootController(final BootRepository bootRepository) {
        this.bootRepository = bootRepository;
    }

    @GetMapping("/")
    public Iterable<Boot> getAllBoots() {

        return this.bootRepository.findAll();

    }

    @GetMapping("/types")
    public List<BootType> getBootTypes() {

        return Arrays.asList(BootType.values());

    }

    @PostMapping("/")
    public Boot addBoot(@RequestBody Boot boot) {

        Boot newBoot = this.bootRepository.save(boot);

        return newBoot;

    }

    @DeleteMapping("/{id}")
    public Boot deleteBoot(@PathVariable("id") Integer id) {
        Optional<Boot> bootToDeleteOptional =this.bootRepository.findById(id);

        if (!bootToDeleteOptional.isPresent()) {
            return null;
        }

        Boot bootToDelete = bootToDeleteOptional.get();

        this.bootRepository.delete(bootToDelete);

        return bootToDelete;

    }

    @PutMapping("/{id}/quantity/increment")
    public Boot incrementQuantity(@PathVariable("id") Integer id) {
        Optional<Boot> bootToIncrementOptional = this.bootRepository.findById(id);

        if (!bootToIncrementOptional.isPresent()) {
            return null;
        }

        Boot bootToIncrement = bootToIncrementOptional.get();

        int currQuantity = bootToIncrement.getQuantity();
        int newQuantity = currQuantity + 1;
        bootToIncrement.setQuantity(newQuantity);

        Boot updatedBoot = this.bootRepository.save(bootToIncrement);
        return updatedBoot;

    }

    @PutMapping("/{id}/quantity/decrement")
    public Boot decrementQuantity(@PathVariable("id") Integer id) {
        Optional<Boot> bootToIncrementOptional = this.bootRepository.findById(id);

        if (!bootToIncrementOptional.isPresent()) {
            return null;
        }

        Boot bootToIncrement = bootToIncrementOptional.get();

        int currQuantity = bootToIncrement.getQuantity();
        int newQuantity = currQuantity - 1;
        bootToIncrement.setQuantity(newQuantity);

        Boot updatedBoot = this.bootRepository.save(bootToIncrement);
        return updatedBoot;
    }

    @GetMapping("/search")
    public List<Boot> searchBoots(@RequestParam(required = false) String material,
                                  @RequestParam(required = false) BootType type, @RequestParam(required = false) Float size,
                                  @RequestParam(required = false, name = "quantity") Integer minQuantity) throws QueryNotSupportedException {
        if (Objects.nonNull(material)) {
            if (Objects.nonNull(type) && Objects.nonNull(size) && Objects.nonNull(minQuantity)) {
                // call the repository method that accepts a material, type, size, and minimum
                // quantity DONE
                return this.bootRepository.findByMaterialAndSizeAndTypeAndQuantityGreatherThan(material, size, type, minQuantity);
            } else if (Objects.nonNull(type) && Objects.nonNull(size)) {
                // call the repository method that accepts a material, size, and type DONE
                return this.bootRepository.findByMaterialAndSizeAndType(material, size, type);
            } else if (Objects.nonNull(type) && Objects.nonNull(minQuantity)) {
                // call the repository method that accepts a material, a type, and a minimum
                // quantity DONE
                return this.bootRepository.findByMaterialAndTypeAndQuantityGreatherThan(material, type, minQuantity);
            } else if (Objects.nonNull(type)) {
                // call the repository method that accepts a material and a type DONE
                return this.bootRepository.findByMaterialAndType(material, type);
            } else {
                // call the repository method that accepts only a material DONE
                return this.bootRepository.findByMaterial(material);
            }
        } else if (Objects.nonNull(type)) {
            if (Objects.nonNull(size) && Objects.nonNull(minQuantity)) {
                // call the repository method that accepts a type, size, and minimum quantity DONE
                return this.bootRepository.findByTypeAndSizeAndQuantityGreatherThan(type, size, minQuantity);
            } else if (Objects.nonNull(size)) {
                // call the repository method that accepts a type and a size DONE
                return this.bootRepository.findByTypeAndSize(type, size);
            } else if (Objects.nonNull(minQuantity)) {
                // call the repository method that accepts a type and a minimum quantity DONE
                return this.bootRepository.findByTypeAndQuantityGreatherThan(type, minQuantity);
            } else {
                // call the repository method that accept only a type DONE
                return bootRepository.findByType(type);
            }
        } else if (Objects.nonNull(size)) {
            if (Objects.nonNull(minQuantity)) {
                // call the repository method that accepts a size and a minimum quantity DONE
                return bootRepository.findBySizeAndQuantityGreatherThan(size, minQuantity);
            } else {
                // call the repository method that accepts only a size DONE
                return this.bootRepository.findBySize(size);
            }
        } else if (Objects.nonNull(minQuantity)) {
            // call the repository method that accepts only a minimum quantity DONE
            return this.bootRepository.findByQuantityGreatherThan(minQuantity);
        } else {
            throw new QueryNotSupportedException("This query is not supported! Try a different combination of search parameters.");
        }
    }

}