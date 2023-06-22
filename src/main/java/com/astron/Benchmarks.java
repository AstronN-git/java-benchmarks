package com.astron;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class Benchmarks {

    @Param({"100", "10000", "100000", "10000000"})
    int n;

    @Benchmark
    @Fork(value = 2, warmups = 1)
    @Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(time = 2000, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void ArrayListDefaultConstructor() {
        var al = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            al.add(i);
        }
    }

    @Benchmark
    @Fork(value = 2, warmups = 1)
    @Warmup(time = 500, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(time = 2000, timeUnit = TimeUnit.MILLISECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void ArrayListSetCapacity() {
        var al = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            al.add(i);
        }
    }
}
