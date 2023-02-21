import styled from "styled-components";

const UpdateSkateDialogWrapper = styled.div`
  h2 {
    background-image: linear-gradient(90deg, #5a0289, #00ffe3);
    border-bottom: 2px solid #5a0289;
    color: white;
  }
  
  .updateSkateForm {
    display: flex;
    flex-direction: row;
    align-items: center;

    .formGroup {
      display: flex;
      flex-direction: column;
      width: 450px;

      >input {
        border: 2px solid #5a0289;
        margin-top: 30px;
        height: 30px;
        border-radius: 30px;
        padding: 15px;
        font-size: 16px;
      }

      .dropdowns {
        display: flex;
        flex-direction: column;

        .MuiBox-root {
          margin-top: 30px;
          
          .MuiFormControl-root {
            border: 2px solid #862297;
            border-radius: 30px;
            
            .MuiFormLabel-root.Mui-focused {
              color: transparent;
            }

            .MuiInputBase-root {
              height: 60px;

              .MuiSelect-select {
                height: 26px;
                border-radius: 30px;
                background-color: white;
              }

              fieldset {
                border-radius: 30px;

                &.MuiOutlinedInput-notchedOutline {
                  border: none;
                }
              }
            } 
          }
        }
      }
    }
  }
  
  .MuiDialogActions-spacing {
    display: flex;
    justify-content: space-around;
    border-top: 2px solid #5a0289;
    background-image: linear-gradient(90deg, #5a0289, #00ffe3);
    color: white;
    
    .MuiButton-root {
      flex: 0 0 50%;
      height: 36px;
      color: white;
    }
  }
`;

export default UpdateSkateDialogWrapper;