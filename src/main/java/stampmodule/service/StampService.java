package stampmodule.service;

import com.google.protobuf.ServiceException;

import stampmodule.model.Stamp;

public interface StampService {

	boolean updateStamp(Stamp stamp) throws ServiceException;

}
