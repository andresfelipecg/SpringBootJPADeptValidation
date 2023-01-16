package com.example.jpa;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MVCController {

	
	@Autowired 
	private CustomerRepository customerRepository;
	
	@Autowired 
	private BookRepository bookRepository;
	
	@Autowired 
	private TransactionRepository transactionRepository;
	
	 // Inject an instance of the FirstController
	 @Autowired
	 private ClientController clientController;
	

	//To get the add-book.html page
	@GetMapping("/addbook")
	public String home(Book book)
	{
		return "add-book";
	}
	
	//To get the add-transaction.html page
		@GetMapping("/addtransaction")
		public String homeTransaction(Transaction transaction)
		{
			return "add-transaction";
		}
	
	//add the Book info
	@PostMapping("/add")
    public String add(@Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }
        bookRepository.save(book);

        //Add list of books
        //model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("books", clientController.getBooks());
        
        //Add available books list
        model.addAttribute("booksavailables", clientController.getBooksAvailable());
        
      //Add lent out  books list
        model.addAttribute("bookslentout", clientController.getBooksLentOut());
        
        //Add list of customers
        model.addAttribute("customers", clientController.getCustomers());
        
        //Add list transactions
        model.addAttribute("transactions", clientController.getTransactions());
       
        
        return "index";
    }
	
	
	
	//add the transaction info
		@PostMapping("/addt")
	    public String addtransaction(@Valid Transaction transaction, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "add-transaction";
	        }
	        transactionRepository.save(transaction);

	        //Add list of books
	        //model.addAttribute("books", bookRepository.findAll());
	        model.addAttribute("books", clientController.getBooks());
	        
	        //Add available books list
	        model.addAttribute("booksavailables", clientController.getBooksAvailable());
	        
	      //Add lent out  books list
	        model.addAttribute("bookslentout", clientController.getBooksLentOut());
	        
	        //Add list of customers
	        model.addAttribute("customers", clientController.getCustomers());
	        
	        //Add list transactions
	        model.addAttribute("transactions", clientController.getTransactions());
	       
	        
	        return "index";
	    }
	
	//Get the edit request
	@GetMapping("/editbook/{id}")
	public String edit(@PathVariable("id") int no, Model model) {
	    Book book = bookRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid book number:" + no));

	    model.addAttribute("book", book);
	    return "update-book";
	}
	//update the existing book info
	@PostMapping("/updatebook/{id}")
	public String update(@PathVariable("id") int no, @Valid Book book,
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        book.setBookid(no);
	        return "update-book";
	    }

	    bookRepository.save(book);
	    model.addAttribute("books",  clientController.getBooks());
	    return "index";
	}
	
	//delete a book info
	@GetMapping("/deletebook/{id}")
	public String delete(@PathVariable("id") int no, Model model) {
	    Book book= bookRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid Book Number:" + no));
	    bookRepository.delete(book);
        model.addAttribute("books",  clientController.getBooks());
	    return "index";
	}
	
	//Get the edit request
	@GetMapping("/edittransaction/{id}")
	public String editTransaction(@PathVariable("id") int no, Model model) {
	    Transaction transaction = transactionRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid Transaction number:" + no));

	    model.addAttribute("transaction", transaction);
	    return "update-transaction";
	}
	//update the existing transaction info
	@PostMapping("/updatetransaction/{id}")
	public String updateTransaction(@PathVariable("id") int no, @Valid Transaction transaction,
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	transaction.setTransactionid(no);
	        return "update-transaction";
	    }

	    transactionRepository.save(transaction);
	    model.addAttribute("transactions",  clientController.getTransactions());
	    return "index";
	}
	
	//delete a transaction info
	@GetMapping("/deletetransaction/{id}")
	public String deleteTransaction(@PathVariable("id") int no, Model model) {
		Transaction transaction= transactionRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid Transaction Number:" + no));
	    transactionRepository.delete(transaction);
        model.addAttribute("transactions",  clientController.getTransactions());
	    return "index";
	}

}
