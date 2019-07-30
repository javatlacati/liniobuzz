export class LinioBuzz {
    public static linianos(number: number): string {
        let array: string[] = [];
        for (let i = 1; i <= number; i++) {
            array.push(LinioBuzz.liniano(i));
        }
        return array.join(' ');
    }

    private static liniano(n: number): string {
        var result: string;
        result = !(n % 15) && 'Linianos';
        result = result || !(n % 3) && 'Linio';
        result = result || !(n % 5) && 'IT';
        return result || `${n}`;
    }
}
