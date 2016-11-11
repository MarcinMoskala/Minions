@file:JvmName("Komprehensions")
@file:Suppress("unused")

package com.marcinmoskala.minions

import rx.Observable

fun <A, R> doL(
        zero: () -> A,
        one: (A) -> R): R =
        zero.invoke().let { a ->
            one.invoke(a)
        }

fun <A, B, R> doL(
        zero: () -> A,
        one: (A) -> B,
        two: (A, B) -> R): R =
        zero.invoke().let { a ->
            one.invoke(a).let { b ->
                two.invoke(a, b)
            }
        }

fun <A, B, C, R> doL(
        zero: () -> A,
        one: (A) -> B,
        two: (A, B) -> C,
        three: (A, B, C) -> R): R =
        zero.invoke().let { a ->
            one.invoke(a).let { b ->
                two.invoke(a, b).let { c ->
                    three.invoke(a, b, c)
                }
            }
        }

fun <A, B, C, D, R> doL(
        zero: () -> A,
        one: (A) -> B,
        two: (A, B) -> C,
        three: (A, B, C) -> D,
        four: (A, B, C, D) -> R): R =
        zero.invoke().let { a ->
            one.invoke(a).let { b ->
                two.invoke(a, b).let { c ->
                    three.invoke(a, b, c).let { d ->
                        four.invoke(a, b, c, d)
                    }
                }
            }
        }

fun <A, B, C, D, E, R> doL(
        zero: () -> A,
        one: (A) -> B,
        two: (A, B) -> C,
        three: (A, B, C) -> D,
        four: (A, B, C, D) -> E,
        five: (A, B, C, D, E) -> R): R =
        zero.invoke().let { a ->
            one.invoke(a).let { b ->
                two.invoke(a, b).let { c ->
                    three.invoke(a, b, c).let { d ->
                        four.invoke(a, b, c, d).let { e ->
                            five.invoke(a, b, c, d, e)
                        }
                    }
                }
            }
        }

fun <A, B, C, D, E, F, R> doL(
        zero: () -> A,
        one: (A) -> B,
        two: (A, B) -> C,
        three: (A, B, C) -> D,
        four: (A, B, C, D) -> E,
        five: (A, B, C, D, E) -> F,
        six: (A, B, C, D, E, F) -> R): R =
        zero.invoke().let { a ->
            one.invoke(a).let { b ->
                two.invoke(a, b).let { c ->
                    three.invoke(a, b, c).let { d ->
                        four.invoke(a, b, c, d).let { e ->
                            five.invoke(a, b, c, d, e).let { f ->
                                six.invoke(a, b, c, d, e, f)
                            }
                        }
                    }
                }
            }
        }

fun <A, B, C, D, E, F, G, R> doL(
        zero: () -> A,
        one: (A) -> B,
        two: (A, B) -> C,
        three: (A, B, C) -> D,
        four: (A, B, C, D) -> E,
        five: (A, B, C, D, E) -> F,
        six: (A, B, C, D, E, F) -> G,
        seven: (A, B, C, D, E, F, G) -> R): R =
        zero.invoke().let { a ->
            one.invoke(a).let { b ->
                two.invoke(a, b).let { c ->
                    three.invoke(a, b, c).let { d ->
                        four.invoke(a, b, c, d).let { e ->
                            five.invoke(a, b, c, d, e).let { f ->
                                six.invoke(a, b, c, d, e, f).let { g ->
                                    seven.invoke(a, b, c, d, e, f, g)
                                }
                            }
                        }
                    }
                }
            }
        }

fun <A, B, C, D, E, F, G, H, R> doL(
        zero: () -> A,
        one: (A) -> B,
        two: (A, B) -> C,
        three: (A, B, C) -> D,
        four: (A, B, C, D) -> E,
        five: (A, B, C, D, E) -> F,
        six: (A, B, C, D, E, F) -> G,
        seven: (A, B, C, D, E, F, G) -> H,
        eight: (A, B, C, D, E, F, G, H) -> R): R =
        zero.invoke().let { a ->
            one.invoke(a).let { b ->
                two.invoke(a, b).let { c ->
                    three.invoke(a, b, c).let { d ->
                        four.invoke(a, b, c, d).let { e ->
                            five.invoke(a, b, c, d, e).let { f ->
                                six.invoke(a, b, c, d, e, f).let { g ->
                                    seven.invoke(a, b, c, d, e, f, g).let { h ->
                                        eight.invoke(a, b, c, d, e, f, g, h)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

fun <A, B, C, D, E, F, G, H, I, R> doL(
        zero: () -> A,
        one: (A) -> B,
        two: (A, B) -> C,
        three: (A, B, C) -> D,
        four: (A, B, C, D) -> E,
        five: (A, B, C, D, E) -> F,
        six: (A, B, C, D, E, F) -> G,
        seven: (A, B, C, D, E, F, G) -> H,
        eight: (A, B, C, D, E, F, G, H) -> I,
        nine: (A, B, C, D, E, F, G, H, I) -> R): R =
        zero.invoke().let { a ->
            one.invoke(a).let { b ->
                two.invoke(a, b).let { c ->
                    three.invoke(a, b, c).let { d ->
                        four.invoke(a, b, c, d).let { e ->
                            five.invoke(a, b, c, d, e).let { f ->
                                six.invoke(a, b, c, d, e, f).let { g ->
                                    seven.invoke(a, b, c, d, e, f, g).let { h ->
                                        eight.invoke(a, b, c, d, e, f, g, h).let { i ->
                                            nine.invoke(a, b, c, d, e, f, g, h, i)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

fun <A, R> doFM(
        zero: () -> Observable<A>,
        one: (A) -> Observable<R>): Observable<R> =
        zero.invoke().flatMap { a ->
            one.invoke(a)
        }

fun <A, B, R> doFM(
        zero: () -> Observable<A>,
        one: (A) -> Observable<B>,
        two: (A, B) -> Observable<R>): Observable<R> =
        zero.invoke().flatMap { a ->
            one.invoke(a).flatMap { b ->
                two.invoke(a, b)
            }
        }

fun <A, B, C, R> doFM(
        zero: () -> Observable<A>,
        one: (A) -> Observable<B>,
        two: (A, B) -> Observable<C>,
        three: (A, B, C) -> Observable<R>): Observable<R> =
        zero.invoke().flatMap { a ->
            one.invoke(a).flatMap { b ->
                two.invoke(a, b).flatMap { c ->
                    three.invoke(a, b, c)
                }
            }
        }

fun <A, B, C, D, R> doFM(
        zero: () -> Observable<A>,
        one: (A) -> Observable<B>,
        two: (A, B) -> Observable<C>,
        three: (A, B, C) -> Observable<D>,
        four: (A, B, C, D) -> Observable<R>): Observable<R> =
        zero.invoke().flatMap { a ->
            one.invoke(a).flatMap { b ->
                two.invoke(a, b).flatMap { c ->
                    three.invoke(a, b, c).flatMap { d ->
                        four.invoke(a, b, c, d)
                    }
                }
            }
        }


fun <A, B, C, D, E, R> doFM(
        zero: () -> Observable<A>,
        one: (A) -> Observable<B>,
        two: (A, B) -> Observable<C>,
        three: (A, B, C) -> Observable<D>,
        four: (A, B, C, D) -> Observable<E>,
        five: (A, B, C, D, E) -> Observable<R>): Observable<R> =
        zero.invoke().flatMap { a ->
            one.invoke(a).flatMap { b ->
                two.invoke(a, b).flatMap { c ->
                    three.invoke(a, b, c).flatMap { d ->
                        four.invoke(a, b, c, d).flatMap { e ->
                            five.invoke(a, b, c, d, e)
                        }
                    }
                }
            }
        }

fun <A, B, C, D, E, F, R> doFM(
        zero: () -> Observable<A>,
        one: (A) -> Observable<B>,
        two: (A, B) -> Observable<C>,
        three: (A, B, C) -> Observable<D>,
        four: (A, B, C, D) -> Observable<E>,
        five: (A, B, C, D, E) -> Observable<F>,
        six: (A, B, C, D, E, F) -> Observable<R>): Observable<R> =
        zero.invoke().flatMap { a ->
            one.invoke(a).flatMap { b ->
                two.invoke(a, b).flatMap { c ->
                    three.invoke(a, b, c).flatMap { d ->
                        four.invoke(a, b, c, d).flatMap { e ->
                            five.invoke(a, b, c, d, e).flatMap { f ->
                                six.invoke(a, b, c, d, e, f)
                            }
                        }
                    }
                }
            }
        }

fun <A, B, C, D, E, F, G, R> doFM(
        zero: () -> Observable<A>,
        one: (A) -> Observable<B>,
        two: (A, B) -> Observable<C>,
        three: (A, B, C) -> Observable<D>,
        four: (A, B, C, D) -> Observable<E>,
        five: (A, B, C, D, E) -> Observable<F>,
        six: (A, B, C, D, E, F) -> Observable<G>,
        seven: (A, B, C, D, E, F, G) -> Observable<R>): Observable<R> =
        zero.invoke().flatMap { a ->
            one.invoke(a).flatMap { b ->
                two.invoke(a, b).flatMap { c ->
                    three.invoke(a, b, c).flatMap { d ->
                        four.invoke(a, b, c, d).flatMap { e ->
                            five.invoke(a, b, c, d, e).flatMap { f ->
                                six.invoke(a, b, c, d, e, f).flatMap { g ->
                                    seven.invoke(a, b, c, d, e, f, g)
                                }
                            }
                        }
                    }
                }
            }
        }

fun <A, B, C, D, E, F, G, H, R> doFM(
        zero: () -> Observable<A>,
        one: (A) -> Observable<B>,
        two: (A, B) -> Observable<C>,
        three: (A, B, C) -> Observable<D>,
        four: (A, B, C, D) -> Observable<E>,
        five: (A, B, C, D, E) -> Observable<F>,
        six: (A, B, C, D, E, F) -> Observable<G>,
        seven: (A, B, C, D, E, F, G) -> Observable<H>,
        eight: (A, B, C, D, E, F, G, H) -> Observable<R>): Observable<R> =
        zero.invoke().flatMap { a ->
            one.invoke(a).flatMap { b ->
                two.invoke(a, b).flatMap { c ->
                    three.invoke(a, b, c).flatMap { d ->
                        four.invoke(a, b, c, d).flatMap { e ->
                            five.invoke(a, b, c, d, e).flatMap { f ->
                                six.invoke(a, b, c, d, e, f).flatMap { g ->
                                    seven.invoke(a, b, c, d, e, f, g).flatMap { h ->
                                        eight.invoke(a, b, c, d, e, f, g, h)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

fun <A, B, C, D, E, F, G, H, I, R> doFM(
        zero: () -> Observable<A>,
        one: (A) -> Observable<B>,
        two: (A, B) -> Observable<C>,
        three: (A, B, C) -> Observable<D>,
        four: (A, B, C, D) -> Observable<E>,
        five: (A, B, C, D, E) -> Observable<F>,
        six: (A, B, C, D, E, F) -> Observable<G>,
        seven: (A, B, C, D, E, F, G) -> Observable<H>,
        eight: (A, B, C, D, E, F, G, H) -> Observable<I>,
        nine: (A, B, C, D, E, F, G, H, I) -> Observable<R>): Observable<R> =
        zero.invoke().flatMap { a ->
            one.invoke(a).flatMap { b ->
                two.invoke(a, b).flatMap { c ->
                    three.invoke(a, b, c).flatMap { d ->
                        four.invoke(a, b, c, d).flatMap { e ->
                            five.invoke(a, b, c, d, e).flatMap { f ->
                                six.invoke(a, b, c, d, e, f).flatMap { g ->
                                    seven.invoke(a, b, c, d, e, f, g).flatMap { h ->
                                        eight.invoke(a, b, c, d, e, f, g, h).flatMap { i ->
                                            nine.invoke(a, b, c, d, e, f, g, h, i)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }