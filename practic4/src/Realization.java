import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Realization implements ExecutorService {
    private ExecutorService fs;
    public Realization(int count){
        fs = Executors.newFixedThreadPool(count);
    }
    @Override
    public void shutdown() {
        fs.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return fs.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return fs.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return fs.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return fs.awaitTermination(timeout, unit);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return fs.submit(task);
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return fs.submit(task, result);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return fs.submit(task);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return fs.invokeAll(tasks);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return invokeAll(tasks, timeout, unit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return fs.invokeAny(tasks);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return fs.invokeAny(tasks, timeout, unit);
    }

    @Override
    public void execute(Runnable command) {
        fs.execute(command);
    }
}
