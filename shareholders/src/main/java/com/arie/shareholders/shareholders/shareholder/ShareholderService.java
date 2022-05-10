package com.arie.shareholders.shareholders.shareholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ShareholderService {

    private final ShareholderRepository shareholderRepository;

    @Autowired
    public ShareholderService(ShareholderRepository shareholderRepository) {
        this.shareholderRepository = shareholderRepository;
    }

    public List<Shareholder> getShareholders() {
        return shareholderRepository.findAll();

    }

    public void addNewShareholder(Shareholder shareholder) {
        Optional<Shareholder> shareholderByEmail = shareholderRepository.findShareholderByEmail(shareholder.getEmail());

        if (shareholderByEmail.isPresent())
            throw new IllegalStateException("Email already taken");

        shareholderRepository.save(shareholder);
    }


    public void deleteShareholder(Long shareholderId) {
        boolean shareholderIsExist = shareholderRepository.existsById(shareholderId);
        if (!shareholderIsExist)
            throw new IllegalStateException("Shareholder with ID = " + shareholderId + " does not exist");

            shareholderRepository.deleteById(shareholderId);

    }

    @Transactional
    public void updateShareholder(Long shareholderId, String name, String email) {

        Shareholder shareholder = shareholderRepository.findById(shareholderId).orElseThrow(() ->
                new IllegalStateException("Shareholder with ID = " + shareholderId + " does not exist"));

        System.out.println("name = "+name+", id = "+ shareholderId);
        if (name !=null && name.length() > 0 && !Objects.equals(shareholder.getName(), name)) {
            System.out.println("name = "+name+", id = "+ shareholderId);
            shareholder.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(shareholder.getEmail(), email)) {

            Optional<Shareholder> optionalShareholder = shareholderRepository.findShareholderByEmail(email);
            if (optionalShareholder.isPresent()) throw new IllegalStateException("Email is already taken");
            shareholder.setEmail(email);
        }

    }
}
