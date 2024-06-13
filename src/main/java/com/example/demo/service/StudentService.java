package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final static Logger log = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        log.info("ADDING INFO FOR STUDENT SRV");
        log.error("ADDING ERROR FOR STUDENT SRV");
        log.trace("ADDING TRACE FOR STUDENT SRV");
        log.debug("ADDING DEBUG FOR STUDENT SRV");
        return studentRepository.save(student);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }


    /*

    public PaymentDto makeFirstPayment(HttpHeaders headers) {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("paymentservice");
        try {
            return circuitBreaker.run(() -> genericRestClient.makeRestCall(null, host, firstEndpoint, HttpMethod.GET, headers, PaymentDto.class),
                    throwable -> genericRestClient.fallBackMethod(headers, host, firstEndpoint, throwable));
        }
        catch (RuntimeException ex){
            return new PaymentDto("circuit-breaker executed","default","default");
        }
    }


     */
}
