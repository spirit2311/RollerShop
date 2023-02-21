import styled from "styled-components";

const CreateFormWrapper = styled.div`
  padding-top: 15px;
  
  .titleSection {
    font-size: 30px;
    color: #862297;
    display: flex;
    justify-content: center;
  }
  
  .MuiBox-root {
    display: flex;
    justify-content: center;
  }
  
  .MuiButtonBase-root {
    font-size: 20px;
    
    &.Mui-selected {
      color: #862297;
    }
  }
  
  .CreateSkateForm {
    display: flex;
    flex-direction: row;
    align-items: center;

    .formGroup {
      display: flex;
      flex-direction: column;
      width: 450px;
      
      >input {
        margin-top: 30px;
        height: 30px;
        border-radius: 30px;
        border: none;
        padding: 15px;
        font-size: 16px;
      }
      
      .dropdowns {
        display: flex;
        flex-direction: column;

        .MuiBox-root {
          margin-top: 30px;

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
  
  .submitContainer {
    display: flex;
    justify-content: center;
    padding-top: 25px;
    
    button {
      background-color: #862297;
      font-size: 25px;
      border-radius: 30px;
    }
  }
`;

export default CreateFormWrapper;