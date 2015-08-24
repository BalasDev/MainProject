package by.epam.project.service;

import by.epam.project.dao.PositionDAO;
import by.epam.project.domain.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{

    @Autowired
    PositionDAO positionDAO;

    @Transactional
    public List<Position> listPosition() {
        return positionDAO.listPosition();
    }
}
