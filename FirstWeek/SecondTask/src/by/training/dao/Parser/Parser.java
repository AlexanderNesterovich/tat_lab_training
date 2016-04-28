package by.training.dao.parser;

import by.training.model.Request;

import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/26/2016.
 */
public interface Parser {

        public void parseByPath(String path);
        public List<Request> getRequestList();

}
