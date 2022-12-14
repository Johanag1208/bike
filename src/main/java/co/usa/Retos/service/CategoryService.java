package co.usa.Retos.service;


import co.usa.Retos.model.Category;
import co.usa.Retos.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category ca) {
        if (ca.getId() == null) {
            return categoryRepository.save(ca);
        } else {
            Optional <Category> caaux=categoryRepository.getCategory(ca.getId());
            if(caaux.isEmpty()){
                return categoryRepository.save(ca);
            }else{
                return ca;
            }
        }
    }
}
