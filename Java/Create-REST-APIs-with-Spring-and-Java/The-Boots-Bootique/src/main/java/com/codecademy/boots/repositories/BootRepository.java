package com.codecademy.boots.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codecademy.boots.entities.Boot;
import com.codecademy.boots.enums.BootType;

public interface BootRepository extends CrudRepository<Boot, Integer>{
    public List<Boot> findBySize(Float size);
    public List<Boot> findByMaterial(String material);
    public List<Boot> findByType(BootType type);
    public List<Boot> findByQuantityGreatherThan(Integer minQuantity);
    public List<Boot> findByMaterialAndSize(String material, Float size);
    public List<Boot> findByMaterialAndQuantityGreatherThan(String material, Integer minQuantity);
    public List<Boot> findByMaterialAndType(String material, BootType type);
    public List<Boot> findByMaterialAndSizeAndType(String material, Float size, BootType type);
    public List<Boot> findByMaterialAndSizeAndTypeAndQuantityGreatherThan(String material, Float size, BootType type,Integer minQuantity);
    public List<Boot> findByTypeAndSize(BootType type, Float size);
    public List<Boot> findByTypeAndSizeAndQuantityGreatherThan(BootType type, Float size, Integer minQuantity);
    public List<Boot> findByTypeAndQuantityGreatherThan(BootType type, Integer minQuantity);
    public List<Boot> findBySizeAndQuantityGreatherThan(Float size, Integer minQuantity);
    public List<Boot> findByMaterialAndTypeAndQuantityGreatherThan(String material, BootType type, Integer minQuantity);
}