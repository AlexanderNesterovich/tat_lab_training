package by.training.dao.local_persistence;

import by.training.dao.exception.DAOException;
import by.training.dao.FilesDAO;
import by.training.bean.Library;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Alexander Nesterovich on 20.05.2016.
 */
public class XmlDAO implements FilesDAO {

    private static final Logger LOG = LogManager.getLogger(XmlDAO.class);
    @Override
    public Library readFromFile(String path) throws DAOException {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Library.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Library lib = (Library) jaxbUnmarshaller.unmarshal(new File(path));
            return lib;
        } catch (JAXBException e) {
            LOG.error("Cannot unmarshall JAXBException");
            throw new DAOException("Cannot unmarshall JAXBException", e);
        }
    }

    @Override
    public void writeToFile(Library lib, String path) throws DAOException {
        try {
            JAXBContext context = JAXBContext.newInstance(Library.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(lib, new FileOutputStream(path));
        } catch (JAXBException e) {
            LOG.error("Cannot marshall JAXBException");
            throw new DAOException("Cannot marshall JAXBException", e);
        } catch (FileNotFoundException e) {
            LOG.error("File Not Found!");
            throw new DAOException("File Not Found!", e);
        }
    }
}
