package t1.debute.techradar.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t1.debute.techradar.entity.Tech;
import t1.debute.techradar.repository.TechRadarRepository;
import t1.debute.techradar.rest.dto.TechDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class TechRadarServiceImpl implements TechRadarService{
    @Autowired
    private  TechRadarRepository repository;
    @Override
    public List<TechDTO> findAllTeches(String filter) {
        if(filter != null && !filter.isBlank()){
            return repository.findAllByLabelLikeIgnoreCase(filter).stream().map(TechDTO::fromTech).collect(Collectors.toList());
        }
        else{
            log.info(repository.findAll().toString());
            return StreamSupport.stream( repository.findAll().spliterator(),false).map(TechDTO::fromTech).collect(Collectors.toList());
        }
    }

    @Override
    public List<TechDTO> findAllTechesByDepartment(String dep) {
        return StreamSupport.stream( repository.findAllByDepartamentLikeIgnoreCase(dep).spliterator(),false).map(TechDTO::fromTech).collect(Collectors.toList());
    }




    @Override
    public TechDTO createTech(String quadrant, String ring, String label, String link, boolean active, String  moved,String department,String description,int rank) {
        return TechDTO.fromTech(repository.save(new Tech(null,quadrant,ring,label,link,active,moved,department,description,rank)));
    }

    @Override
    public void updateTech(Integer id, String quadrant, String ring, String label, String link, boolean active, String  moved,String department,String description,int rank) {
        Optional<Tech> byId = repository.findById(id);
        if(byId.isPresent()){

        repository.save(new Tech(id,quadrant,ring,label,link,active,moved,department,description,rank));}
    }

    @Override
    public void deleteTech(Integer id) {
        Optional<Tech> byId = repository.findById(id);
        if(byId.isPresent()){

            repository.deleteById(id);}
    }
    @Override
    public void deleteTech(String label){
        Optional<Tech> tech = repository.findFirstByLabelLikeIgnoreCase(label);
        if(tech.isPresent()){

        repository.deleteById(repository.findFirstByLabelLikeIgnoreCase(label).get().getId());}
    }





}
