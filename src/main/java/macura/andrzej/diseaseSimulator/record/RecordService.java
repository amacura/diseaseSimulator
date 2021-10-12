package macura.andrzej.diseaseSimulator.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecordService {
    @Autowired
    RecordRepository repository;
    public List<Record> getall()
    {
        return repository.findAll();
    }

}
