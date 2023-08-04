package stampmodule.service;


import stampmodule.dao.StampDao;

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
        try {
            if (StampValidator.validateStamp(stamp)) {
                return stampDao.addStamp(stamp);
            } else {
                throw new ServiceException("Invalid stamp attributes");
            }
        } catch (DaoException e) {
            throw new ServiceException("Error while adding stamp", e);
        }
    }

    public Stamp getStampByName(String name) throws ServiceException {
        try {
            return stampDao.getStampByName(name);
        } catch (DaoException e) {
            throw new ServiceException("Error while fetching stamp", e);
        }
    }

    @Override
    public boolean updateStamp(Stamp stamp) throws ServiceException {
        try {
            if (StampValidator.validateStamp(stamp)) {
                return stampDao.updateStamp(stamp);
            } else {
                throw new ServiceException("Invalid stamp attributes");
            }
        } catch (DaoException e) {
            throw new ServiceException("Error while updating stamp", e);
        }
    }

    public boolean deleteStamp(String name) throws ServiceException {
        try {
            return stampDao.deleteStamp(name);
        } catch (DaoException e) {
            throw new ServiceException("Error while deleting stamp", e);
        }
    }
}
