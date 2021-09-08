package ws.synopsis.training.service;

import ws.synopsis.training.beans.model.Person;
import ws.synopsis.training.beans.request.LibraryAsign;

import java.util.List;

public interface LibraryService {

    public void assing(LibraryAsign assing);
    public void unassing(LibraryAsign assing);

}
