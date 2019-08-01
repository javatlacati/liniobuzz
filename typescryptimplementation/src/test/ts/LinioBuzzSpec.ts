import {LinioBuzz} from "../../main/ts/LinioBuzz";
import 'mocha';
import {assert} from 'chai';

describe("Test Suite", function (): void {
    describe("Linio Buzz Tests", function (): void {
        it("should produce correctly the first 100 samples", function (): void {
            // expect(LinioBuzz.linianos(100))
            //     .toBe("1 2 Linio 4 IT Linio 7 8 Linio IT 11 Linio 13 14 Linianos 16 17 Linio 19 IT Linio 22 23 Linio IT 26 Linio 28 29 Linianos 31 32 Linio 34 IT Linio 37 38 Linio IT 41 Linio 43 44 Linianos 46 47 Linio 49 IT Linio 52 53 Linio IT 56 Linio 58 59 Linianos 61 62 Linio 64 IT Linio 67 68 Linio IT 71 Linio 73 74 Linianos 76 77 Linio 79 IT Linio 82 83 Linio IT 86 Linio 88 89 Linianos 91 92 Linio 94 IT Linio 97 98 Linio IT")
            assert.equal(
                "1 2 Linio 4 IT Linio 7 8 Linio IT 11 Linio 13 14 Linianos 16 17 Linio 19 IT Linio 22 23 Linio IT 26 Linio 28 29 Linianos 31 32 Linio 34 IT Linio 37 38 Linio IT 41 Linio 43 44 Linianos 46 47 Linio 49 IT Linio 52 53 Linio IT 56 Linio 58 59 Linianos 61 62 Linio 64 IT Linio 67 68 Linio IT 71 Linio 73 74 Linianos 76 77 Linio 79 IT Linio 82 83 Linio IT 86 Linio 88 89 Linianos 91 92 Linio 94 IT Linio 97 98 Linio IT"
                , LinioBuzz.linianos(100)
            );
        })
    })
});
