package com.example.boot3java17;

public sealed interface SealedBase permits SealedBase.SealedImpl1, SealedBase.SealedImpl2, SealedBase.SealedImpl3, SealedBase.SealedImpl4, SealedBase.TestClass, TestClass {

    public final class SealedImpl1 implements SealedBase{};
    public final class SealedImpl2 implements SealedBase{};
    public non-sealed class SealedImpl3 implements SealedBase{};
    public non-sealed class SealedImpl4 implements SealedBase{};
    public non-sealed class TestClass implements SealedBase {};

}
