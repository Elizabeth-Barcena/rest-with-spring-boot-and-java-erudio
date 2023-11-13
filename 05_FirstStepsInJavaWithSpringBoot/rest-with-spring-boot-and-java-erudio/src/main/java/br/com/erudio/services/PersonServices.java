package br.com.erudio.services;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVoV2;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;
@Service
public class PersonServices {
    @Autowired
    PersonRepository repository;
    @Autowired
    PersonMapper mapper;
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    public List<PersonVO> findAll(){
        logger.info("Find all people");
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }
    public PersonVO findById(Long id){
        logger.info("Find one person");

        Person person = new Person();
        person.setFirstName("Leandro");
        person.setLastName("Costa");
        person.setAddress("Uberlandia");
        person.setGender("Male");

        var entity= repository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("No record found for this ID!"));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }
    public PersonVO create(PersonVO person){
        logger.info("Creating one person");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return  vo;
    }
    public PersonVoV2 createV2(PersonVoV2 person){
        logger.info("Creating one person V2");
        var entity = mapper.convertVoToEntity(person);
        var vo = mapper.convertEntityToVo(repository.save(entity));
        return  vo;
    }
    public PersonVO update(PersonVO person){
        logger.info("Update one person");
        var entity = repository.findById(person.getId())
                .orElseThrow(()-> new ResourceNotFoundException("No record found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return  vo;
    }
    public void delete(Long id){
        logger.info("Delete one person");
        var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No record found for this ID!"));
        repository.delete(entity);
    }


}
