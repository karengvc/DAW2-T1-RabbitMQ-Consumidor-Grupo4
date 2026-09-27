package pe.edu.cibertec.appgrupo4consumidor.rabbitmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.appgrupo4consumidor.config.RabbitMqConfig;
import pe.edu.cibertec.appgrupo4consumidor.service.FibonacciService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Slf4j
@Component
public class FibonacciConsumidor {

    private final FibonacciService fibonacciService;

    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void calcularSecuenciaFibonacci(String cadenaNumeros)
            throws InterruptedException {
        log.info("Mensaje recibido desde RabbitMQ: {}", cadenaNumeros);

        Integer[] integerArray = Stream.of(cadenaNumeros.split(";"))
                .map(String::trim)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        List<Integer> posiciones = Arrays.asList(integerArray);
        log.info("Posiciones a calcular: {}", posiciones);

        log.info("Calculando secuencia de Fibonacci...");
        Thread.sleep(20000);

        List<Long> resultado = fibonacciService.calculateSequence(posiciones);
        log.info("Resultado Fibonacci: {}", resultado);
        log.info("-----------------------------------------");
    }
}