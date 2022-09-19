package com.project.sportmate.main.hunt.dao;

import com.project.sportmate.main.hunt.model.Hunt;
import org.springframework.stereotype.Repository;

@Repository
public interface HuntDAO {

    public int insertHunt(Hunt hunt);


}
