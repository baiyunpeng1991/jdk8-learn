package com.jdk8.learn.stream;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamStartTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("111111");
        list.add("111112");
        list.add("111113");
        list.add("111114");
        long count = list.stream().filter(w -> w.length() > 1).count();
        System.out.println("args = [" + count + "]");
        long count1 = list.parallelStream().filter(w -> w.length() > 3).count();
        System.out.println("args = [" + count1 + "]");
        Stream<Serializable> serializableStream = Stream.of("1", "2", new int[]{1, 3, 2});
        serializableStream.forEach(serializable -> System.out.println("args = [" + serializable + "]"));
        //创建不包含任何元素的流
        Stream<Object> empty = Stream.empty();
        //创建无限流 1
        Stream<String> generate = Stream.generate(() -> "echo");
        //无限循环
        generate.forEach(s-> System.out.println("args = [" + s + "]"));
        Stream<Double> doubleStream = Stream.generate(Math::random);
        doubleStream.forEach(d-> System.out.println("args = [" + d + "]"));
        //创建无限流 2
        Stream<BigInteger> iterate = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));

    }
}
