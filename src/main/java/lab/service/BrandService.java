package lab.service;

import lab.entity.Brand;
import lab.entity.Model;
import lab.entity.dto.BrandDTO;
import lab.entity.dto.ModelDTO;
import lab.repositories.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandDTO> getBrands(){
       return  brandRepository
               .findAll()
               .stream()
               .map(this::mapBrand)
               .collect(Collectors.toList());
    }

    private BrandDTO mapBrand(Brand brand){

        List<ModelDTO> models = brand.getModels()
                .stream()
                .map(this::mapModel)
                .collect(Collectors.toList());

        BrandDTO result = new BrandDTO();
        result.setModels(models);
        result.setName(brand.getName());
        return result;

    }

    private ModelDTO mapModel(Model model){
        ModelDTO result = new ModelDTO();
        result.setId(model.getId());
        result.setName(model.getName());
        return result;

    }
}
