package com.codility.challenge.titanium2016;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * <a href="https://codility.com/programmers/task/brackets_rotation/">Brackets Rotation</a>
 *
 * <h1>Идеи</h1>
 *
 * <h2>Нечетное N</h2>
 *
 * <p>Для любого нечетного N проблема сводится к двум поискам по четному N-1 и вычислению максимума</p>
 *
 * <pre>
 *     int r1 = solution(s[2:n],   k)
 *     int r2 = solution(s[1:n-1], k)
 *     return max(r1, r2)
 * </pre>
 *
 * <h2>Результат</h2>
 *
 * <p>Для N < 2 результат R=0.</p>
 *
 * <p>Результат R всегда четный (кратен 2). Если правильная последовательность начинается на четном индексе, то и
 * заканчивается на четном. Если начинается на нечетном, то и заканчивается на нечетном.</p>
 *
 * <h2>Аналитический расчет</h2>
 *
 * <p>Если K=N (N четное), то результат равен N независимо от входной строки - потенциально у нас есть возможность
 * повернуть ВСЕ скобки в ЛЮБОЕ состояние.</p>
 *
 * <p>Максимальный бюджет K, необходимый для получения результата N (N четное) для последовательности длины N
 * в худшем случае:</p>
 *
 * <ul>
 *     <li>N=0, K=0</li>
 *     <li>N=2, K=2 ')('</li>
 *     <li>N=4, K=3 ')((('</li>
 *     <li>N=6, K=4 ')((((('</li>
 *     <li>N=8, K=5 ')((((((('</li>
 *     <li>N=10, K=6 ')((((((((('</li>
 *     <li>N=12, K=7 ')((((((((((('</li>
 *     <li>...</li>
 * </ul>
 *
 * <p>Это похоже на "кворум" = (N/2+1), и таким образом для любого K >= (N/2+1) можно сразу возвращать N</p>
 *
 * <h2>Количество проходов (не важно)</h2>
 *
 * <p>Если нам нужно выяснить какие именно скобки ротировать (на самом деле это не требуется), то однопроходный
 * алгоритм не может сработать, поскольку результат зависит от всех элементов, и нужно как минимум два прохода.</p>
 *
 * <p>Пример:</p>
 *
 * <pre>
 * ')))(((' --[K=2]-> ')()()(' (r=4)
 * '))()((' --[K=2]-> '()()()' (r=6)
 * </pre>
 *
 * <p>Видим что сдвиг внешних скобок зависит от того, знаем ли мы в каком состоянии внутренние скобки.</p>
 */
public class BracketsRotationTest {

    private BracketsRotation solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new BracketsRotation();
    }

    @Test
    public void testNull() throws Exception {
        Assert.assertEquals(0, solution.solution(null, 0));
        Assert.assertEquals(0, solution.solution(null, 2));
        Assert.assertEquals(0, solution.solution("", 0));
        Assert.assertEquals(0, solution.solution("", 2));
    }

    @Test
    public void test1() throws Exception {
        Assert.assertEquals(6, solution.solution("((()))", 0));
        Assert.assertEquals(6, solution.solution("((()))", 1));
        Assert.assertEquals(6, solution.solution("((()))", 2));
        Assert.assertEquals(6, solution.solution("((()))", 3));
        Assert.assertEquals(6, solution.solution("((()))", 4));
        Assert.assertEquals(6, solution.solution("((()))", 5));
        Assert.assertEquals(6, solution.solution("((()))", 6));
    }

    @Test
    public void test2() throws Exception {
        Assert.assertEquals(0, solution.solution(")))(((", 0));
        Assert.assertEquals(2, solution.solution(")))(((", 1));
        Assert.assertEquals(4, solution.solution(")))(((", 2)); // )()()(
        Assert.assertEquals(6, solution.solution(")))(((", 4)); // ()()(), ()(()), (()())
        Assert.assertEquals(6, solution.solution(")))(((", 6));
    }

    @Test
    public void test3() throws Exception {
        Assert.assertEquals(2, solution.solution("))()((", 0));
        Assert.assertEquals(6, solution.solution("))()((", 2)); // ()()()
        Assert.assertEquals(6, solution.solution("))()((", 4)); // ()()(), ((())), ()(())
        Assert.assertEquals(6, solution.solution("))()((", 6));
    }

    @Test
    public void test4() throws Exception {
        Assert.assertEquals(2, solution.solution("))()((", 0));
        Assert.assertEquals(6, solution.solution("))()((", 2)); // ()()()
        Assert.assertEquals(6, solution.solution("))()((", 4));
        Assert.assertEquals(6, solution.solution("))()((", 6));
    }

    @Test
    public void test5() throws Exception {
        // - compaction algorithm is bad ('(()))(())' -> '4)4')
        // - greedy algorithm is bad
        Assert.assertEquals(4, solution.solution("(()))(())", 0));
        Assert.assertEquals(8, solution.solution("(()))(())", 1)); // (()()(())
    }

    @Test
    public void test6() throws Exception {
        Assert.assertEquals(4, solution.solution(")()()(", 0));
        Assert.assertEquals(4, solution.solution(")()()(", 1));
        Assert.assertEquals(6, solution.solution(")()()(", 2));
    }

    @Test
    public void test7() throws Exception {
        Assert.assertEquals(0, solution.solution(")(", 1));
        Assert.assertEquals(2, solution.solution(")(", 2));

        Assert.assertEquals(2, solution.solution(")(((", 2));
        Assert.assertEquals(4, solution.solution(")(((", 3));

        Assert.assertEquals(4, solution.solution(")(((((", 3));
        Assert.assertEquals(6, solution.solution(")(((((", 4));

        Assert.assertEquals(6, solution.solution(")(((((((", 4));
        Assert.assertEquals(8, solution.solution(")(((((((", 5));
    }

    @Test
    public void test8() throws Exception {
        Assert.assertEquals(4, solution.solution(")(((((", 3));
        Assert.assertEquals(6, solution.solution("))((((", 3));
        Assert.assertEquals(4, solution.solution(")))(((", 3));
        Assert.assertEquals(6, solution.solution("))))((", 3));
        Assert.assertEquals(4, solution.solution(")))))(", 3));
    }

    @Test
    public void test9() throws Exception {
        Assert.assertEquals(2, solution.solution("((()", 0));
        Assert.assertEquals(4, solution.solution("((()", 1));

        Assert.assertEquals(2, solution.solution("()))", 0));
        Assert.assertEquals(4, solution.solution("()))", 1));

        Assert.assertEquals(4, solution.solution("(((())", 0));
        Assert.assertEquals(6, solution.solution("(((())", 1));

        Assert.assertEquals(4, solution.solution("(())))", 0));
        Assert.assertEquals(6, solution.solution("(())))", 1));

        Assert.assertEquals(6, solution.solution("((()(())", 0));
        Assert.assertEquals(8, solution.solution("((()(())", 1));

        Assert.assertEquals(6, solution.solution("(())()))", 0));
        Assert.assertEquals(8, solution.solution("(())()))", 1));
    }

    @Test
    public void test10() throws Exception {
        Assert.assertEquals(4, solution.solution("(()))()", 0));
        Assert.assertEquals(6, solution.solution("(()))()", 1));
    }

}