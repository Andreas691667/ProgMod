import org.sireum.logika._


val qt : Z = readInt() // target angle
val TimeStep : Z = readInt()
var q : Z = readInt()
val dq : Z = readInt()

val N1 : Z = 0
val N2 : Z = 157 // pi-halve gange 100
val M1 : Z = -17
val M2 : Z = 174

def Step(timeFactor: Z): Unit = {
  l"""{
        pre TimeStep > 0
            qt >= N1 & qt <= N2
            q >= M1 & q <= M2
            dq = 0 | (TimeStep <= (M2 - q)/dq & TimeStep >= (M1 - q)/dq & (dq < 0 | dq>0))

        modifies q

        post q <= M2 ^ q>= M1
    }"""

  q = q + dq * TimeStep

  l"""{
        1. q = q_old + dq * TimeStep                                          premise
        2. TimeStep > 0                                                       premise
        3. qt >= N1 ^ qt <= N2                                                premise
        4. q_old >= M1 ^ q_old <= M2                                          premise
        5. dq = 0 ∨ (TimeStep <= (M2 - q_old)/dq ^ TimeStep >= (M1 - q_old)/dq ^ (dq < 0 ∨ dq>0))         premise

        6. q_old >= M1    ^e1 4
        7. q_old <= M2    ^e2 4

        10. {
          11. dq = 0                   assume
          12. q = q_old + 0 * TimeStep subst1 11 1
          13. q <= M2 algebra 12 7
          14. q >= M1 algebra 12 6
          15. q <= M2 ^ q>= M1 ^i 13 14
        }

        20. {
          21. ((TimeStep <= (M2 - q_old)/dq) ^ (TimeStep >= (M1 - q_old)/dq)) ^ (dq < 0 ∨ dq>0)  assume
          22. ((TimeStep <= (M2 - q_old)/dq) ^ (TimeStep >= (M1 - q_old)/dq)) ^e1 21
          23. TimeStep <= (M2 - q_old)/(dq) ^e1 22
          24. TimeStep >= (M1 - q_old)/(dq) ^e2 22
          25. dq < 0 ∨ dq >0 ^e2 21
          200. {
            201. dq>0   assume
            202. q_old + dq * TimeStep >= M1 algebra 24 201 2 6
            203. q_old + dq * TimeStep <= M2 algebra 23 201 2 7
            204. q <= M2 subst2 1 203
            205. q >= M1 subst2 1 202
            206. q <= M2 ^ q>= M1 ^i 204 205
          }
          300. {
            301. dq<0   assume
            302. q_old + dq * TimeStep >= M1 algebra 23 301 2 7 6
            303. q_old + dq * TimeStep <= M2 algebra 24 301 2 6 7
            304. q <= M2 subst2 1 303
            305. q >= M1 subst2 1 302
            306. q <= M2 ^ q>= M1 ^i 304 305
          }

          26. q <= M2 ^ q>= M1 ∨e 25 300 200

        }
        8. q <= M2 ^ q>= M1   ∨e 5 10 20
    }"""
}