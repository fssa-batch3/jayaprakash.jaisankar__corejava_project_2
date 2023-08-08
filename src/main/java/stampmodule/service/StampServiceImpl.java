package stampmodule.service;


import com.google.protobuf.ServiceException;

import stampmodule.dao.DaoException;
import stampmodule.model.Stamp;
import stampmodule.validation.InvalidateStampException;
import stampmodule.validation.StampValidator;

public class StampServiceImpl implements StampService {
    private StampDao stampDao;

    public StampServiceImpl(StampDao stampDao) {
        this.stampDao = stampDao;
    }

    public boolean addStamp(Stamp stamp) throws ServiceException {
        if (StampValidator.validateStamp(stamp)) {
		    return ((StampServiceImpl) stampDao).addStamp(stamp);
		} else {
		    throw new ServiceException("Invalid stamp attributes");
		}
    }

    public Stamp getStampByName(String name) throws ServiceException, DaoException {
        return ((StampServiceImpl) stampDao).getStampByName(name);
    }

    @Override
    public boolean updateStamp(Stamp stamp) throws ServiceException {
        if (StampValidator.validateStamp(stamp)) {
		    return ((StampServiceImpl) stampDao).updateStamp(stamp);
		} else {
		    throw new ServiceException("Invalid stamp attributes");
		}
    }

    public boolean deleteStamp(String name) throws ServiceException {
        return ((StampServiceImpl) stampDao).deleteStamp(name);
    }
}
