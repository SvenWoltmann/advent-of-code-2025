package eu.happycoders.adventofcode2025.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RangeTest {

  @Test
  void givenValidString_whenParse_thenCreatesCorrectRange() {
    String input = "5-10";

    Range range = Range.parse(input);

    assertThat(range.from()).isEqualTo(5);
    assertThat(range.to()).isEqualTo(10);
  }


  @Test
  void givenRange1EqualsRange2_whenTryMergeWith_thenReturnsRange1() {
    Range range1 = new Range(3, 7);
    Range range2 = new Range(3, 7);

    Range merged = range1.tryMergeWith(range2);

    assertThat(merged).isEqualTo(range1);
  }

  @Test
  void givenRange1ContainsRange2_whenTryMergeWith_thenReturnsRange1() {
    Range range1 = new Range(1, 9);
    Range range2 = new Range(3, 7);

    Range merged = range1.tryMergeWith(range2);

    assertThat(merged).isEqualTo(range1);
  }

  @Test
  void givenRange2ContainsRange1_whenTryMergeWith_thenReturnsRange2() {
    Range range1 = new Range(3, 5);
    Range range2 = new Range(3, 7);

    Range merged = range1.tryMergeWith(range2);

    assertThat(merged).isEqualTo(range2);
  }

  @Test
  void givenRange1IsLeftOfRange2WithAGap_whenTryMergeWith_thenReturnsNull() {
    Range range1 = new Range(1, 3);
    Range range2 = new Range(5, 7);

    Range merged = range1.tryMergeWith(range2);

    assertThat(merged).isNull();
  }

  @Test
  void givenRange1IsLeftOfRange2WithNoGap_whenTryMergeWith_thenReturnsMergedRange() {
    Range range1 = new Range(1, 3);
    Range range2 = new Range(4, 6);

    Range merged = range1.tryMergeWith(range2);

    assertThat(merged.from()).isEqualTo(1);
    assertThat(merged.to()).isEqualTo(6);
  }

  @Test
  void givenRange1IsLeftOfRange2WithOverlap_whenTryMergeWith_thenReturnsMergedRange() {
    Range range1 = new Range(1, 5);
    Range range2 = new Range(4, 7);

    Range merged = range1.tryMergeWith(range2);

    assertThat(merged.from()).isEqualTo(1);
    assertThat(merged.to()).isEqualTo(7);
  }

  @Test
  void givenRange1IsRightOfRange2WithAGap_whenTryMergeWith_thenReturnsNull() {
    Range range1 = new Range(5, 7);
    Range range2 = new Range(1, 3);

    Range merged = range1.tryMergeWith(range2);

    assertThat(merged).isNull();
  }

  @Test
  void givenRange1IsRightOfRange2WithNoGap_whenTryMergeWith_thenReturnsNull() {
    Range range1 = new Range(5, 7);
    Range range2 = new Range(2, 4);

    Range merged = range1.tryMergeWith(range2);

    assertThat(merged.from()).isEqualTo(2);
    assertThat(merged.to()).isEqualTo(7);
  }

  @Test
  void givenRange1IsRightOfRange2WithOverlap_whenTryMergeWith_thenReturnsNull() {
    Range range1 = new Range(5, 9);
    Range range2 = new Range(2, 7);

    Range merged = range1.tryMergeWith(range2);

    assertThat(merged.from()).isEqualTo(2);
    assertThat(merged.to()).isEqualTo(9);
  }
}