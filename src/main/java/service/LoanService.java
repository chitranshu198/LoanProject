package service;

import com.example.Store.entity.Loan;
import com.example.Store.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoanService {

    private LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void saveLoan(Loan loan){

        if(loan.getPaymentDate().isAfter(loan.getDueDate())){
            throw new IllegalArgumentException("Payment date cannot be greater than due date");
        }

        loanRepository.save(loan);
    }

    public List<Loan> getAllLoans(){

        LocalDateTime lt = LocalDateTime.now();

        List<Loan> loans=loanRepository.findAll();

        loans.forEach(loan-> {
            if(loan.getPaymentDate().isBefore(lt)){
                System.out.println("Payment is due, please clear the dues asap!!!");
            }
        });
        return loans;
    }
}
